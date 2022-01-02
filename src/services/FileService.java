package services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileService {
	public static void copy(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}
}
