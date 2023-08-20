package com.mecenatpolis.mcnp.service;

import com.mecenatpolis.mcnp.DAO.McnpDAO;
import com.mecenatpolis.mcnp.DAO.SignUpDAO;
import com.mecenatpolis.mcnp.VO.SignUpVO;
import com.mecenatpolis.mcnp.service.serviceInf.MncpServiceInf;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MncpService implements MncpServiceInf {

    @Resource
    private McnpDAO mcnpDAO;

    @Override
    public Map<String,Object> signUp(SignUpVO signUpVO) {

        return null;
    }

}
