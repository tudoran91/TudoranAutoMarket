package ro.tudoran.AutoMarketEshop;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartSession {
    List<Integer> modelIds;

    public List<Integer> getmodelIds() {
        if(modelIds == null) {
            modelIds = new ArrayList<>();
        }
        return modelIds;
    }

    public void setmodelIds(List<Integer> modelIds) {
        this.modelIds = modelIds;
    }
}
