package com.example.pharmwebspring.Service.Impl;

import com.example.pharmwebspring.DAO.ProductDaoB;
import com.example.pharmwebspring.DAO.ProductDaoT;
import com.example.pharmwebspring.Model.ProductB;
import com.example.pharmwebspring.Model.ProductT;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

public class ProductDaoTImpl {
    @Repository //DB관련 객체를 스프링에서 대신 관리해주게하는 어노테이션
    public class ProductTDaoImpl implements ProductDaoT {

        @Inject //sqlSession을 의존성을 주입해서 스프링 자체에서 객체를 생성하고 소멸시키게끔 한다.
        SqlSession sqlSession;


        public List<ProductT> listProductT() {
            return sqlSession.selectList("productT.listproductT");
        }

        @Override
        public ProductT detailProductT(String prodT_name) {
            return sqlSession.selectOne(//sqlsession에 저장된 값중에 하나를 리턴한다 (상품번호)
                    "product.detailT_product", prodT_name);
            //앞쪽에 namespace와 뒤쪽에 id를 적는다. 이렇게 해야 Mapper와 매핑이 된다.
        }
    }
}
