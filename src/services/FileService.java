package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.RendererException;
import org.ghost4j.renderer.SimpleRenderer;

import helpers.ImageConverter;
import javafx.scene.image.WritableImage;

public class FileService {
	public static void copy(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}
	
	public static List<WritableImage> getPreview(File file) throws FileNotFoundException, IOException, RendererException, DocumentException {
		List<WritableImage> images = new LinkedList<WritableImage>();
		
		PDFDocument document = new PDFDocument();
	    document.load(new File(file.getPath()));

	    SimpleRenderer renderer = new SimpleRenderer();
	    renderer.setResolution(300);

	    List<java.awt.Image> rawImages = renderer.render(document);
	    
	    for (java.awt.Image generated : rawImages) {
			images.add(ImageConverter.convertFromAwtToWritableImage(generated));
	    }
	    
	    return images;
	}
}
