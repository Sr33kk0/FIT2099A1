# REQ4: The Facility Alarm System (HD Requirement)
Although the moon is abandoned, the moon’s facility alarm is still active.

This is a High Distinction (HD) requirement. You are provided with the theme and the functional requirements below, but the underlying object-oriented design and implementation details are entirely up to you. You must design a robust, scalable way for the alarm system to interact with the game's existing entities, actors, and map.

To successfully satisfy this requirement, your implementation must include all of the following:

## Triggering the alarm
You must implement one way to activate the alarm. You can choose one trigger from the following examples OR come up with your own.

- A new creature (e.g., a security camera or watcher) that activates the alarm if a worker is within its surroundings.

- A new item on the ground that instantly trips the alarm the moment a worker picks it up and adds it to their inventory.

- A new type of floor or tile that silently triggers the alarm as soon as a worker steps onto it.

## The consequences of triggering the alarm
You must implement two different consequences of triggering the alarm. Similar to the first point, you can implement the following examples OR come up with your own.

- All hostile entities (like the Undead) immediately override their standard wandering behaviour. They must move directly toward the worker, regardless of their proximity or distance on the map.

- All doors are locked tight, and tools, including the AccessCard (▤), cannot be used to open them for a certain number of turns.

- Automated Security Drones are spawned into the map. These drones are highly aggressive and will actively hunt down and attack any moving entity (workers and other creatures alike) within their surroundings.

Note that the rules above must be strictly followed. Not following one or more rules will result in the HD requirement not being marked.

It is also important to apply the SOLID principles in the implementation. The application must then be explained clearly in the design rationale. Implementing the requirement without any application of the SOLID principles will be considered as not completing the HD requirement.