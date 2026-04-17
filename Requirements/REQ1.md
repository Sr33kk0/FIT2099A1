# REQ1: Garbage Collection Inc.
### This requirement has been partially implemented, though the current design needs improvement. Please refactor the implementation to enhance the overall structure and quality.

In this game, players play as expendable, minimum-wage workers contracted by the mega-corporation Garbage Collection Inc. Their job is to get into the abandoned moons in the Eclipse Nebula to collect valuable scrap, discarded items, and corporate assets that have piled up in the dark.

The moons are highly unstable and hazardous. The corporation doesn't care about your survival; they only care about their bottom line. The workers must navigate the facilities on the moons, grab the loot, and survive their shift before the moons’ anomalies wipe them out.

The game supports multiple players taking on the roles of the contracted workers (`ඞ`). Each worker begins their shift with an inventory with a weight limit of 50 units. 

All players start the game with a Flask (`u`) already in their inventory. The flask weighs 3 units, and it can be drunk five times, with each use healing 1 point of health. Once the flask is depleted, the empty flask must not be removed; it remains in the worker’s inventory.

The workers arrive at the moon’s facility on the company’s armoured ship. For the purpose of the implementation, an “armoured ship” is represented by a combination of Walls (`#`), Floors (`_`), and a Door (`=`).

---
In the armoured ship, three items can be found and picked up by the workers:

AccessCard (`▤`): Weighing just 1 unit, this card can be used to open any door in the facility. At the start of the game, one worker needs to pick up an access card to open the ship’s door.

FirstAidKit (`+`): A super useful weighing 25 units. It can be used to permanently increase a worker’s maximum health by 1 point while simultaneously restoring their health to full. It requires a 20-turn cooldown between uses. Crucially, the 20-turn timer only progresses while the kit is actively being carried by a worker; if it is left on the floor, the cooldown timer stops.

SterilisationBox (`▣`): This item weighs 7 units and provides the necessary function of sterilising any consumables, including items and grounds, found on the moon’s facility.

---
### **Note**: To make the game more challenging, these three items should only be instantiated once in the game to force the players to split the responsibilities among the workers, e.g., one worker carrying the access card, one worker carrying the first aid kit, and another one carrying the sterilisation box.