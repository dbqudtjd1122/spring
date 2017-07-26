package com.spring81.bbs.service;

import com.spring81.bbs.dao.IDaoBoard;
import com.spring81.bbs.model.ModelArticle;

public interface IServiceBoard extends IDaoBoard {
    
    public abstract ModelArticle transUpdateHitAndGetArticle(int articleno);

}
