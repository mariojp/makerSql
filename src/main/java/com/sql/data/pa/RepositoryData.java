package com.sql.data.pa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import com.sql.core.pa.RepositoryBase;

public class RepositoryData implements InvocationHandler {

   private Class<?> repositoryInterface;
   private Class<?> idClass;
   private Class<?> repositoryClass;

   public RepositoryData(Class<?> repository){
      this.repositoryInterface = repository;
   }

   @Override
   public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
      findTypeRepository();
      return null;
   }
    
   public Object initRepository(){
      return Proxy.newProxyInstance(repositoryInterface.getClassLoader(), new Class[]{repositoryInterface}, this);
   }

   public void findTypeRepository(){
      Type type = repositoryInterface.getGenericInterfaces()[0];
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length > 0) {
               repositoryClass = (Class<?>) typeArguments[0];
               idClass = (Class<?>) typeArguments[1]; 
            }
        }
   }

   @SuppressWarnings("unchecked")
   public static <E extends RepositoryBase<?, ?>> E createProxy(Class<E> repositoryInterface) {
      return (E) Proxy.newProxyInstance(
              repositoryInterface.getClassLoader(),
              new Class[]{repositoryInterface},
              new RepositoryData(repositoryInterface)
      );
   }
}
