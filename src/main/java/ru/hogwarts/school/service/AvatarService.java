package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class AvatarService {
    @Value("avatar")
    private String avatarDir;

    private final StudentService studentService;
    private final AvatarRepository avatarRepository;
    public AvatarService(StudentService studentService, AvatarRepository avatarRepository) {
        this.studentService = studentService;
        this.avatarRepository = avatarRepository;
    }

    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        Student student = studentService.readStudent(studentId).toStudent();

        Path filePath = Path.of(avatarDir, studentId + ".jpg");
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is);
             BufferedOutputStream bos = new BufferedOutputStream(os);
             ){
            bis.transferTo(bos);
            }
        Avatar avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setMediaType(file.getContentType());
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(file.getSize());
        avatar.setPreview(generateImagePreview(filePath));
        avatarRepository.save(avatar);

    }
    public Avatar findAvatar(Long studentId){
        return avatarRepository.findByStudentId(studentId).orElse(new Avatar());
    }

    public byte[] generateImagePreview(Path filePath) throws IOException {
        try (InputStream is = Files.newInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                 BufferedImage image = ImageIO.read(bis);
                 int height = image.getHeight() / (image.getWidth() / 100);
                 BufferedImage preview = new BufferedImage(100, height, image.getType());
                 Graphics2D graphics = preview.createGraphics();
                 graphics.drawImage(image, 0, 0, 100, height, null);
                 graphics.dispose();
                 ImageIO.write(preview, filePath.getFileName().toString(), baos);
                 return baos.toByteArray();
             }


    }

}
