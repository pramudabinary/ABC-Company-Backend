package lk.abc.spring.service.impl;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import lk.abc.spring.service.AdminService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Override
    public AdminDTO adminLogin(LoginRequestDTO loginRequestDTO) {
        return null;
    }
}
