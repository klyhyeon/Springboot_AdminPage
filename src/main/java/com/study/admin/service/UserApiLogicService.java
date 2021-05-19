package com.study.admin.service;

import com.study.admin.interfaces.CrudInterface;
import com.study.admin.model.network.Header;
import com.study.admin.model.network.request.UserApiRequest;
import com.study.admin.model.network.response.UserApiResponse;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    /**
     * 1. Request data
     * 2. User 생성
     * 3. 생성된 데이터 -> UserApiResponse return
     * */
    @Override
    public Header<UserApiResponse> create(UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(UserApiRequest userApiRequest) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }
}
