(defrule r1 (monkey at-the-door) => (printout t "monkey is heading to the box" crlf) (retract 1) (assert (monkey at-the-box))))
(defrule r2 (monkey hands-free) (monkey at-the-box) => (printout t "the monkey can gran the box" crlf) (assert (monkey busy-hands-box)) (retract 3)(retract 2))
(defrule r3 (monkey busy-hands-box)(monkey not-below-banana) => (printout t "monkey should go below to the banana" crlf) (assert (monkey below-banana)) (retract 5))
(defrule r4 (monkey busy-hands-box)(monkey below-banana)=>(printout t "monkey must drop the box" crlf)(retract 4) (assert (monkey hands-free)) (assert (box below-banana)))

(defrule r5 (monkey hands-free) (box below-banana) (monkey below-banana) => (printout t "monkey must climb into the box" crlf)(assert (monkey on-the-box)))
(defrule r6 (monkey below-banana)(monkey hands-free) (box below-banana) (monkey on-the-box) => (printout t "monkey can take the banana" crlf)(assert(monkey take-the-banana)))
(defrule r7 (monkey take-the-banana) => (printout t "the monkey chokes with the banana and dies" crlf) (assert (monkey die)))