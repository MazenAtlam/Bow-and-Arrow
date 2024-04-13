# Balloon

## Constructor

| Syntax | Balloon(PApplet parent, int xPos, char color) |
| --- | --- |
| Parameters | **int xPos**: The x-coordinate of the balloon on the screen <br>  **char color**: the color of the balloon; ‘y’ for yellow balloon, ‘r’ for red balloon |

## Attributes & Methods

| width | static variable returns the width of the balloon |
| --- | --- |
| height | static variable returns the height of the balloon |
| setup() | Initializing the balloon and loading the image. Must be called at the setup stage of the program |
| show() | Renders the balloon on screen |
| showWithBoundaryBox() | Renders the balloon on screen with its boundary box around it |
| updateYPos() | moves the balloon |
| pop() | pops the balloon |
