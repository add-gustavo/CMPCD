package com.br.cmpcd;

import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;

public class Criptografia {

    public static String conversterParaMD5(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes());
        byte[] digest = md.digest();
        String resultado = new String(Hex.encodeHex(digest));
        return resultado;
    }
}
