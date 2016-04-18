/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Benjamin Matase, Jason Corriveau, Eric Marshall, Alexander Murph
 * Date: Apr 13, 2016
 * Time: 5:09:51 PM
 *
 * Project: csci205FinalProject
 * Package: BattleUtility
 * File: SwitchPokemonEvent
 * Description: An event to be passed the GUI.  Updates things to show an
 * animation based off the fact that a pokemon has fainted.
 *
 * ****************************************
 */
package BattleUtility;

import PokemonObjects.Pokemon;

/**
 *
 * @author Murph
 */
public class SwitchPokemonEvent extends Event {

    Pokemon switchPokemon = null;

    public SwitchPokemonEvent(Pokemon PokeSwitch) {
        this.switchPokemon = PokeSwitch;
    }

    public Pokemon getSwitchPokemon() {
        return switchPokemon;
    }

}