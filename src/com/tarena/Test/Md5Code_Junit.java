package com.tarena.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tarena.util.Md5Code;

public class Md5Code_Junit {

	@Test
	public void testCreateMd5Code() throws Exception {
		String md5=Md5Code.createMd5Code("testetst");
		System.out.println(md5);
	}

}
