package lk.abc.spring.service;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */
public interface AdminService {
    AdminDTO adminLogin(LoginRequestDTO loginRequestDTO);
}
