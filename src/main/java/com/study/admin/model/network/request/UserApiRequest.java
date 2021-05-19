package com.study.admin.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//클라이언트 단에서 받는 변수들
public class UserApiRequest {

    private Long id;

    private String account;

    private String email;

    private String password;

    private String status;

    private String phoneNumber;
}
