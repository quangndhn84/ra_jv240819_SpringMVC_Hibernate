package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.Categories;
import ra.com.repository.CategoriesRepository;
import ra.com.service.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId);
    }

    @Override
    public boolean save(Categories catalog) {
        return categoriesRepository.save(catalog);
    }

    @Override
    public boolean update(Categories catalog) {
        Categories catalogUpdate = categoriesRepository.findById(catalog.getCatalogId());
        catalogUpdate.setCatalogName(catalog.getCatalogName());
        catalogUpdate.setDescription(catalog.getDescription());
        catalogUpdate.setStatus(catalog.isStatus());
        return categoriesRepository.update(catalogUpdate);
    }

    @Override
    public boolean delete(int catalogId) {
        return categoriesRepository.delete(catalogId);
    }
}
