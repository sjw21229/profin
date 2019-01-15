package com.qf.manager.service;

import com.qf.manager.po.Sysgallery;

import java.util.List;


public interface CalleryService {
    List<Sysgallery> listsSysgallery(String categoryId);
}
