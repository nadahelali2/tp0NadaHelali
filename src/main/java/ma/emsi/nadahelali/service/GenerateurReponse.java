
package ma.emsi.nadahelali.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service pour générer une réponse personnalisée
 * selon le contenu de la question.
 */
@Dependent
public class GenerateurReponse implements Serializable {

    /**
     * Génère une réponse en fonction de la question saisie.
     *
     * @param question La question de l'utilisateur.
     * @param roleSysteme Le rôle choisi pour la conversation.
     * @return Une réponse personnalisée.
     */
    public String genererReponse(String question, String roleSysteme) {

        String texte = question.trim().toLowerCase(Locale.FRENCH);
        String reponse;

        if (texte.contains("bonjour") || texte.contains("salut")) {
            reponse = "Bonjour ! Comment puis-je vous aider ?";
        } else if (texte.contains("merci")) {
            reponse = "Avec plaisir !";
        } else if (texte.contains("comment vas-tu") ||
                texte.contains("comment allez-vous")) {
            reponse = "Je vais très bien, merci !";
        } else if (texte.contains("au revoir") || texte.contains("bye")) {
            reponse = "Au revoir et à bientôt !";
        } else {
            reponse = "Vous avez écrit : " + question.trim();
        }

        if (roleSysteme != null && !roleSysteme.isBlank()) {
            reponse = "Rôle : " + roleSysteme + "\n" + reponse;
        }

        return reponse;
    }
}
