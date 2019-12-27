package com.yaoren.common.framework.util;


import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 个人邮箱需要 授权码
 */
public class SendEmail {
    private static final String HOST = "smtp.qq.com";  //smtp.exmail.qq.com
    private static final Integer PORT = 587;  //587
    private static final String Protocol = "smtp";
    private static final String USERNAME = "2890266912@qq.com";  // SystemNotice@eptison
    private static final String PASSWORD = "wanswvwmnndrdcce ";  //  kuErMYr5AMtyHdDH  N0tic321
    private static final String EMAILFORM = "2890266912@qq.com";  //systemnotice@eptison.com
    private static JavaMailSenderImpl mailSender = createMailSender();
    //private JavaMailSender mailSender_;
    /**
     * 邮件发送器
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setProtocol(Protocol);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "false");
        //设置调试模式可以在控制台查看发送过程
        //p.put("mail.debug", "true");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 发送邮件
     * @param to 接受人
     * @param subject 主题
     * @param text 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     *  作者：earin
    链接：https://www.jianshu.com/p/da4d0137893a
    來源：简书
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void sendHtmlMail(String to, String subject, String text) {
        /*MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");*/

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(EMAILFORM);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailSender.send(mailMessage);
        /*MimeMessage mimeMessage = new MimeMessage(createSession());
        try {
            mimeMessage.setFrom(new InternetAddress(EMAILFORM,EMAILFORM));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题
            mimeMessage.setSubject(subject);
            mimeMessage.setSentDate(new Date());
            //设置内容
            mimeMessage.setText(text);
            mimeMessage.saveChanges();
            //发送
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/


    }
    private static Session createSession(){
        Properties prop = new Properties();
        //协议
        prop.setProperty("mail.transport.protocol", "smtp");
        //服务器
        prop.setProperty("mail.smtp.host", HOST);
        //端口
        prop.setProperty("mail.smtp.port", "465");  //465
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //
        //获取Session对象
        Session s = Session.getDefaultInstance(prop,new Authenticator() {
            //此访求返回用户和密码的对象
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                PasswordAuthentication pa = new PasswordAuthentication(USERNAME, PASSWORD);
                return pa;
            }
        });
        //设置session的调试模式，发布时取消
        s.setDebug(true);
        return s;
    }

}
