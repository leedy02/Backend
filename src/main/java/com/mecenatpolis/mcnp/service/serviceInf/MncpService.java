package com.mecenatpolis.mcnp.service.serviceInf;



import com.mecenatpolis.mcnp.VO.SignUpVO;

import java.util.Map;

public interface MncpServiceInf {
    public Map<String, Object> signUp(SignUpVO signUpVO);
}
