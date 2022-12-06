
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule gripe
     (paciente (nombre ?n)(sintoma1 Tos) (sintoma2 Hackeka) (sintoma3 Nauseas))
   =>
   (printout t "El paciente " ?n " tiene gripe" crlf))


(defrule infeccion-estomacal
     (paciente (nombre ?n)(sintoma1 Fatiga) (sintoma2 Vista-Borrosa) (sintoma3 Hackeka))
   =>
   (printout t "El paciente " ?n " una infección estomacal" crlf))

(defrule alergia
     (paciente(nombre ?n)(sintoma1 Sarpullido) (sintoma2 Diarrea) (sintoma3 Fiebre))
   =>
   (printout t "El paciente " ?n " tiene una alergia" crlf))
