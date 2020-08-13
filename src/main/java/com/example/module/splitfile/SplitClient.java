package com.example.module.splitfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class SplitClient {

	public static void main(String[] args) throws FileNotFoundException {
		Pattern p = Pattern.compile("[,\\.\\-;]");
		final CharSequence splitIt = new FileAsCharSequence(new File("C:\\Users\\akasagar\\Desktop\\stampedLock.txt"));
		p.splitAsStream(splitIt).forEach(System.out::println);

	}

}
