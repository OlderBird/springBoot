package cn.aq.springboot.servlet;

/**编写和服务器有关的配置
 * 配置类*/
public class MyServerConfig {
    /**    EmbeddedServletContainerCustomizer（嵌入式servlet容器定制）这个在spring boot2.X的版本中就不再提供支持
     在不支持的情况下需要这样:
     @Component
     public class ErrorPageConfig implements ErrorPageRegistrar {

         @Override
         @Bean
         public void registerErrorPages(ErrorPageRegistry registry) {
             ErrorPage error400Page=new ErrorPage(HttpStatus.BAD_REQUEST,"/error400" );
             ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/error401");
             ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error500");
             registry.addErrorPages(error400Page,error401Page,error500Page);
         }
     }
     */

}
