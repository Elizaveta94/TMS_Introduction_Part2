package com.tms.lesson42;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class AppStartCounter {
    @Value("${counter-file-name}")
    private String fileName;

    public void increaseCount() throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            int count = Integer.parseInt(Files.readString(file.toPath()));
            count++;
            Files.writeString(file.toPath(), String.valueOf(count));
        } else {
            Files.writeString(file.toPath(), "1");
        }
    }
}
