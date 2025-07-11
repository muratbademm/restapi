package dev.spring.restapi.core.utilies;

import dev.spring.restapi.core.result.Result;
import dev.spring.restapi.core.result.ResultData;
import dev.spring.restapi.dto.response.CursorResponse;
import dev.spring.restapi.dto.response.category.CategoryResponse;
import org.springframework.data.domain.Page;

public class ResultHelper
{
    public  static <T>ResultData <T> created(T data){
       return new ResultData(true,Msg.CREATED,"201",data);
    }
    //her veri eklediğimiz de created olunca return içinde ki mesajları basacak.
    public static  <T> ResultData<T> validateError (T data){
        return new ResultData(true,Msg.CREATED,"400",data);
    }
    public  static <T> ResultData<T> success (T data){
        return new ResultData<>(true,Msg.SUCCESS,"200",data);
    }
    public  static Result notFoundError (String msg){
        return new Result(false,msg,"404");
    }
    public  static Result successResult(){
        return new Result(true,Msg.SUCCESS,"200");
    }
    public  static <T> ResultData<CursorResponse<T>> cursor( Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageSize(pageData.getSize() );
        cursor.setPageNumber(pageData.getNumber());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}
