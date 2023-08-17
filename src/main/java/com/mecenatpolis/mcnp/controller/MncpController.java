package com.mecenatpolis.mcnp.controller;

import com.mecenatpolis.mcnp.DTO.TCodeFormDTO;
import com.mecenatpolis.mcnp.service.MncpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.nio.file.Files;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mecenatpolis")
public class MncpController {

    @Autowired
    public MncpService serviceImpl;
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
