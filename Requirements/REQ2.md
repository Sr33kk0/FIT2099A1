# REQ2: Starter Moon: 99-Deprecated

 The moon “99-Deprecated” is an obsolete, forgotten rock on the outer fringes of the Eclipse Nebula. 2000 years ago, it served as an early data-dumping ground and administrative outpost for Garbage Collection Inc. before the megacorp upgraded its systems and abandoned the facility overnight.

## There are several “valuable” scraps and items the workers can find in the moon’s facility. These scraps can be picked up and dropped off by the workers. Some may have a special interaction with the worker.

- Apple (`ó`): Weighing 1 unit, this spoiled fruit is toxic to anyone or anything consuming it. If eaten without a SterilisationBox, it poisons the consumer (1 damage per turn for 5 turns. Note that there is no way to remove the poison other than waiting it out). If the consumer has a SterilisationBox in their inventory, it heals them for 3 points instead. It disappears from the inventory once consumed.

- Cookies (`◍`): Weighing 2 units, this item contains 5 individual cookies, i.e., it can be used five times. Eating one permanently decreases the consumer's maximum HP by 1. However, with a SterilisationBox, each cookie heals the consumer by 1 HP. The item disappears from the inventory only after all 5 cookies have been eaten.

#### EDIT (7/4): Items that the worker want to consume need to be inside their inventory.

Lantern (`&`): Weighing 7 units, this unstable light source starts with an oil fuel of 10 units. While being carried, it has a 5% chance each turn to leak and ignite the ground beneath the actor. This reduces the lantern's oil fuel by 1 unit and spawns a fire (`^`) on that specific tile. The fire remains on the ground for 5 turns, burning any actor standing on it for 1 damage per turn for 5 turns.

#### EDIT (15/4): Added a missing detail: "The fire remains on the ground for 5 turns, burning any actor standing on it for 1 damage per turn for 5 turns". Previously, how long the fire should be on the ground was not clear.

### For the purpose of this assignment, you can assume that all grounds are flammable.

- Floppy Disk (`⊟`): A piece of ancient technology. It is extremely lightweight (weight of 1).
CRT Monitor (`◙`): A massive, incredibly heavy piece of archaic junk, taking up a massive 30 units of weight in the worker's inventory.
Additionally, the workers can also interact with the moon’s environment. 

- Puddles (`~`): Workers can attempt to drink directly from mysterious puddles found on the moon's surface. In other words, the workers do NOT need to fill up their flask to drink from the puddles (in other words, the flask cannot be refilled, at least, in this version of the game); there must be an option to drink from puddles if they are standing right on top of one. The outcome depends entirely on whether they have the SterilisationBox in their inventory:
If the worker is not carrying the Sterilisation Box, the water is toxic and poisons them, dealing 1 damage per turn for 3 turns.
If the worker is carrying the Sterilisation Box, the water is purified and heals them for 1 health point.