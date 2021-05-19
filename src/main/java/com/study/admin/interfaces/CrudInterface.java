package com.study.admin.interfaces;

import com.study.admin.model.network.Header;
import com.study.admin.model.network.request.UserApiRequest;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Req req); //TODO: request Object 추가

    Header<Res> read(Long id);

    Header<Res> update(Req req);

    Header<Res> delete(Long id);
}
