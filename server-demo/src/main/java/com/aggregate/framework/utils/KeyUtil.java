package com.aggregate.framework.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class KeyUtil {

    /**
     * 从证书文件加载公钥
     * <p>
     * 用于获取服务网关的公钥,用于发送数据加密和收到报文的验签
     * </p>
     *
     * @param certFileUri 证书文件URI,支持物理路径和classpath:
     * @return JCE标准公钥对称, 用户后续加密和验签
     */
    public static PublicKey loadPublicKeyFromCert(String certFileUri) {
        InputStream in = null;
        try {
            Resource resource = new DefaultResourceLoader().getResource(certFileUri);
            in = resource.getInputStream();
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate x509 = (X509Certificate) cf.generateCertificate(in);
            return x509.getPublicKey();
        } catch (Exception e) {
            throw new RuntimeException("加载公钥失败:" + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
//ig
                }

            }
        }
    }


    /**
     * 商户证书(pfx)加载私钥
     *
     * 用于: 商户发送签名的签名和收到报文数据的解密。
     *
     * @param keystoreUri pfx文件的URI,支持物理路径和classpath:
     * @param keystorePassword pfx保护密码
     * @return JCE标准私钥
     */
    public static PrivateKey loadPrivateKeyFromKeyStore(String keystoreUri, String keystorePassword) {
        InputStream in = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            Resource resource = new DefaultResourceLoader().getResource(keystoreUri);
            in = resource.getInputStream();
            keyStore.load(in, keystorePassword.toCharArray());

            Enumeration<String> enumas = keyStore.aliases();
            String keyAlias = null;
            if (enumas.hasMoreElements()) {
                keyAlias = enumas.nextElement();
            }
            return (PrivateKey) keyStore.getKey(keyAlias, keystorePassword.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("通过keystore加载私钥失败:" + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
//ig
                }

            }
        }
    }
}
