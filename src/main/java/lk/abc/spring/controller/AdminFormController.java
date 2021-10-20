package lk.abc.spring.controller;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import lk.abc.spring.service.AdminService;
import lk.abc.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */


@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminFormController {

    @Autowired
    private AdminService adminService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/0auth/token" )
    public ResponseEntity<StandardResponse> findAdminByNameAndPassword(@RequestBody LoginRequestDTO loginRequestDTO) {
        AdminDTO adminDTO = adminService.adminLogin(loginRequestDTO);

        return new ResponseEntity<>(new StandardResponse("200", "Login Success", adminDTO),
                HttpStatus.OK);
    }
}
