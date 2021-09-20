package com.evergreen.app

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class NullOnEmptyConverterFactory:Converter.Factory(){
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val delegate = retrofit.nextResponseBodyConverter<Any>(this,type,annotations)

/* return Converter<ResponseBody,Object>(body:ResponseBody) {
      override fun convert(body:ResponseBody):Object{
          return delegate.convert("")
      }
  }*/

  return null
}


}

/*
* class NullOnEmptyConverterFactory implements Converter.Factory {
@Override
* public Converter<ResponseBody, ?> responseBody(Type type, Annotation[] annotations, Retrofit retrofit) {
  final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
  return new Converter<>() {
      @Override public void convert(ResponseBody body) {
          if (body.contentLength() == 0) return null;
          return delegate.convert(body);
      }
  };
}
}
* */