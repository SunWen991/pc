package com.heidian.backstage.service;

import com.heidian.backstage.dao.TextDao;
import com.heidian.backstage.dao.UserDao;
import com.heidian.backstage.domain.Text;
import com.heidian.backstage.domain.User;
import com.yaoren.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @date ：Created in 2019/12/24 14:24
 * @description：微博用户
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class UserService extends BaseServiceImpl<User, String> {

    @Autowired
    private TextDao textDao;

    @Autowired
    private UserDao userDao;

    public int save() {

        List<Text> textList = textDao.listAll();

        List<Text> textList1 = new ArrayList<>();
        List<Text> textList2=new ArrayList<>();
        textList1.addAll(textList);
        Iterator<Text> textIterator1 = null;
        User user = null;
        for (Text text : textList) {
            boolean tt = false;
            textIterator1 = textList1.iterator();
            while (textIterator1.hasNext()) {
                Text text1 = textIterator1.next();
                if (text.getAuthor().equals(text1.getAuthor())) {
                    if (tt) {
                        textIterator1.remove();
                    } else {
                        tt = true;
                    }
                }
            }
            textList2.clear();
            textList2.addAll(textList1);
            textList1=new ArrayList<>();
            textList1.addAll(textList2);
        }
        for (Text text : textList1) {
            user = new User();
            user.setUserName(text.getAuthor());
            getUserData(user);
            save(user);
        }
        return 0;
    }

    private int getEvenNum(int a, int b) {
        return a + (int) (Math.random() * (b - a));
    }

    private User getUserData(User user) {
        String sex[] = {"男", "男", "女", "女"};
        user.setSex(sex[getEvenNum(0, 3)]);
        user.setDistrict(userDao.getCity(getEvenNum(2, 1500)).getDistrict());
        int month = getEvenNum(1, 12);
        String str = null;
        if (month >= 10) {
            str = getEvenNum(2000, 2019) + "-" + month + "-" + getEvenNum(1, 30);
        } else {
            str = getEvenNum(2000, 2019) + "-" + "0" + month + "-" + getEvenNum(1, 30);
        }
        user.setCreateTime(str);
        return user;
    }

}
