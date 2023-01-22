package com.aariyan.cp;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String value = "https://vexio.ro/carduri-memorie/transcend/65843-ts16gcf1000-16gb-compact-flash-1000x/";
        String sha1 = "";

        String[] threshold = {"https://", "http://","www."};
        for (String index : threshold) {
            if (value.contains(index)) {
                value = value.replace(index,"").trim();
            }
        }

        if (value.contains("?")) {
            int indexOf = value.indexOf("?");
            value = value.substring(0, indexOf);
        }

        //System.out.println(value);

        if (value.endsWith("/")) {
            value = value.substring(0,value.length() - 1);
        }

        System.out.println(value);

        // With the java libraries
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
        if (sha1.equals("c9c5a08579fcba7b20c721d29914bab3f5c16f19")) {
            System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        }

    }
}
