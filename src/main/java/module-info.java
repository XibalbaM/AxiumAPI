module io.github.xibalbaM.axiumApi {

    requires lombok;
    requires spring.core;
    requires com.fasterxml.jackson.annotation;
    requires java.sql;
    requires spring.web;
    requires spring.webflux;
    requires reactor.core;

    exports io.github.xibalbaM.axiumApi;
    opens io.github.xibalbaM.axiumApi;
}