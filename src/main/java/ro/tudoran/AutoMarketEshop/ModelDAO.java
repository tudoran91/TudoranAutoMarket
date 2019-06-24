package ro.tudoran.AutoMarketEshop;

import java.util.List;

public interface ModelDAO {
    public List<Model> findAll();
    public List<Model> findAllByBrandId(Integer brandId);
    public Model findById(Integer modelId);
}
