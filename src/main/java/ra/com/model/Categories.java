package ra.com.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categories {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;
    @Column(name = "catalog_name", columnDefinition = "varchar(100)", unique = true, nullable = false)
    private String catalogName;
    @Column(name = "catalog_description", columnDefinition = "text")
    private String description;
    @Column(name = "catalog_status")
    private boolean status;
    @OneToMany(mappedBy = "catalog")
    private List<Product> listProduct = new ArrayList<>();
}
