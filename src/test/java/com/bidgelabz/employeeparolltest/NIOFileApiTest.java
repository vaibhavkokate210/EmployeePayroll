package com.bidgelabz.employeeparolltest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.employeepayroll.FileUtil;

public class NIOFileApiTest 
{	
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
		
	@Test
	public void givenPath_WhenChecked_ThenConfirmed() throws IOException 
	{
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		
		Path playPath = Paths.get(HOME+'/'+PLAY_WITH_NIO);
		if (Files.exists(playPath)) FileUtil.deleteFolder(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));
		
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));
		
		IntStream.range(1, 10).forEach(n->{
			Path tempFile = Paths.get(playPath + "/temp" + n);
			Assert.assertTrue(Files.notExists(tempFile));
			try { Files.createFile(tempFile);}
			catch (IOException e) {}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath,path->path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
	}
}
