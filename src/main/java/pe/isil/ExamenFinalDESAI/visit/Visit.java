package pe.isil.ExamenFinalDESAI.visit;

import lombok.Data;
import pe.isil.ExamenFinalDESAI.affiliate.Affiliate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tbl_visitas")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dniAffiliate;

    private String local;

    private Date date;

    private String hour;

}