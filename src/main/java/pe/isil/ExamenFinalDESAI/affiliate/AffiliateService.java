package pe.isil.ExamenFinalDESAI.affiliate;

import java.util.List;

public interface AffiliateService {
    AffiliateDTO addAffiliate(Affiliate affiliate);

    Affiliate findAffiliateByDniAffiliate(String dni_affiliate);

    List<Affiliate> findAll();

    AffiliateDTO updateAffiliate(Affiliate affiliate, Long id);

    void deleteAffiliate(Long id);

    Affiliate findAffiliateById(Long id);
}
