package com.mecenatpolis.mcnp.impl;

import com.jcraft.jsch.*;
import com.mecenatpolis.mcnp.DTO.TCodeFormDTO;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Properties;

@Service
public class ServiceImpl implements ServiceIfImpl {
    @Override
    public void makeTerrafromCode(TCodeFormDTO tCodeFormDTO) {
        File file = new File(".\\src\\main\\java\\com\\mecenatpolis\\mcnp\\tfTemp\\main.tf");
        try{
            if(file.createNewFile()){
                System.out.println("File created");
                FileWriter fw = new FileWriter(file);
                fw.write(tCodeFormDTO.getData());
                fw.close();
            }
            else{
                System.out.println("File already Exist");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transferTerraformCode() {
        String fileLocation = ".\\src\\main\\java\\com\\mecenatpolis\\mcnp\\tfTemp\\main.tf";
        JSch jSch = new JSch();
        Session session;
        ChannelSftp sftp;
        String requestContent = "";

        try {
            String id = "ubuntu";
            String ip = "43.201.107.17";
            Integer port = 22;
            String pw = "qwe123!@#";

            session = jSch.getSession(id, ip, port);
            session.setPassword(pw);

            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");

            session.setConfig(properties);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();

            sftp = (ChannelSftp) channel;


            try {
                String checkFileName = "main.tf";
                sftp.cd("/home");

                InputStream inputStream = null;
                inputStream = sftp.get(checkFileName);

            } catch (Exception e) {
                System.out.println(e.toString());
                sftp.quit(); //sftp 종료
                session.disconnect(); //세션 종료
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e);
        }

        System.out.println("finished");
    }

}
