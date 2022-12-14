package pe.isil.ExamenFinalDESAI.affiliate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {
    Optional<Affiliate> findAffiliateByDniAffiliate(String dni_affiliate);
}
