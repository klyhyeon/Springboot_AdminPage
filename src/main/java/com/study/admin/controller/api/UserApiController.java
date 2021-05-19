package com.study.admin.controller.api;

import com.study.admin.interfaces.CrudInterface;
import com.study.admin.model.network.Header;
import com.study.admin.model.network.request.UserApiRequest;
import com.study.admin.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header<UserApiResponse> delete(@PathVariable Long id) {
        return null;
    }
}
