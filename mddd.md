The project involved the implementation of four classes: Archer, Arrow, Balloon, and Shape. These classes were utilized to create a simple interactive game where the archer shoots arrows to pop balloons.

*Design Choices:*
- *Class Hierarchy:* 
  - *Archer:* Represents the player character who shoots arrows.
  - *Arrow:* Represents the projectile fired by the archer.
  - *Balloon:* Represents the target objects that the player aims to pop.
  - *Shape:* An abstract class serving as the base for Archer, Arrow, and Balloon classes, facilitating code organization and reuse.
- *Interactions:*
  - *Archer and Arrow:* The archer triggers the firing method in the arrow upon user input.
  - *Arrow and Balloon:* The arrow triggers the popping method in the balloons upon collision.
- *Supplementary Interactions:*
  - *Score Calculations:* Implemented to track the player's score based on balloon pops.
  - *Level Calculations:* Implemented to determine the player's progress through different levels based on score thresholds.

*Challenges Faced:*
1. *Rendering Order:* Initially encountered issues with rendering objects in the correct order, particularly with the status bar overlapping balloons. Resolved by adjusting rendering order to ensure the status bar appeared in front.
2. *Collision Detection:* Faced challenges in implementing collision detection between arrows and balloons. Overcame by passing an array containing all balloons in the scene to the arrow object, enabling accurate collision detection.
