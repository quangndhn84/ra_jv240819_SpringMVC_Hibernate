package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.com.model.Categories;
import ra.com.repository.CategoriesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoriesRepositoryImp implements CategoriesRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Categories> findAll() {
        return entityManager.createQuery("from Categories", Categories.class).getResultList();
    }

    @Override
    public Categories findById(int catalogId) {
        return entityManager.createQuery("from Categories c where c.catalogId = :id", Categories.class)
                .setParameter("id", catalogId).getSingleResult();
    }

    //Khi thêm, sửa, xóa có thể gây ra lỗi nên cần quản lý transaction --> có lỗi nó rollback, thành công --> commit
    @Override
    @Transactional
    public boolean save(Categories catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Categories catalog) {
        try {
            entityManager.merge(catalog);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int catalogId) {
        try {
            Categories catalog = findById(catalogId);
            entityManager.remove(catalog);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
