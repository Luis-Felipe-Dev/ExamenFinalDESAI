package pe.isil.ExamenFinalDESAI.affiliate;

import lombok.Data;
import pe.isil.ExamenFinalDESAI.visit.Visit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_afiliado", uniqueConstraints = {
        @UniqueConstraint(columnNames = "dniAffiliate", name = "unique_dni_affiliate")
})
@Data
public class Affiliate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dniAffiliate;

    private String name;

    private String lastname;

    private String urlPhoto;

    @OneToMany(mappedBy = "dniAffiliateVisit")
    private List<Visit> visits;
}