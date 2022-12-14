package pe.isil.ExamenFinalDESAI.visit;

import java.util.List;

public interface VisitService {

    VisitDTO addVisit(Visit visit);

    Visit findVisitByLocal(String local);

    List<Visit> findAll();

    VisitDTO updateVisit(Visit visit, Long id);

    void deleteVisit(Long id);

    Visit findVisitById(Long id);
}
