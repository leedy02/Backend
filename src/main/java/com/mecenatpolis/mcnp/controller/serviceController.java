package com.mecenatpolis.mcnp.controller;

import com.mecenatpolis.mcnp.DTO.TCodeFormDTO;
import com.mecenatpolis.mcnp.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mecenatpolis")
public class serviceController {

    @Autowired
    public ServiceImpl serviceImpl;
    @PostMapping(value = "/form")
    public String postTCodeForm(@RequestBody TCodeFormDTO tCodeFormDTO)  {

        serviceImpl.makeTerrafromCode(tCodeFormDTO);
        serviceImpl.transferTerraformCode();
        String path = ".\\src\\main\\java\\com\\mecenatpolis\\mcnp\\tfTemp\\main.tf";
        try{
            boolean result = Files.deleteIfExists(Paths.get(path));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return "OK";
    }

}
