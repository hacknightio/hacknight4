import React from "react";
import { Burrito } from "../models/burrito";

// export const BurritoDetails = (props: {
//     burrito: Burrito,
//     total: number
//   }) => {
//     const {burrito, total} = props;
//     const burritoNum = total / burrito.cost
//     const burritoTotalCalories = burritoNum * burrito.calories
//     const kidsToFeed = burritoTotalCalories / 2000
//     return (
//       <tr>
//         <td className="Burrito-column">
//           {burrito.name}
//         </td>
//         <td>
//           {burritoNum}
//         </td>
//         <td>
//           {burritoTotalCalories}
//         </td>
//         <td>
//           {kidsToFeed}
//         </td>
//       </tr>
//     );
//   };

import PropTypes from 'prop-types';
import { withStyles, Theme } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardMedia from '@material-ui/core/CardMedia';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Collapse from '@material-ui/core/Collapse';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import red from '@material-ui/core/colors/red';
import FavoriteIcon from '@material-ui/icons/Favorite';
import ShareIcon from '@material-ui/icons/Share';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import MoreVertIcon from '@material-ui/icons/MoreVert';

const styles = (theme: Theme) =>({
  card: {
    maxWidth: 400,
  },
  media: {
    height: 0,
    paddingTop: '56.25%', // 16:9
  },
  actions: {
    display: 'flex',
  },
  expand: {
    transform: 'rotate(0deg)',
    marginLeft: 'auto',
    transition: theme.transitions.create('transform', {
      duration: theme.transitions.duration.shortest,
    }),
  },
  expandOpen: {
    transform: 'rotate(180deg)',
  },
  avatar: {
    backgroundColor: red[500],
  },
});

export const BurritoDetails = (props: {
  burrito: Burrito,
  total: number,
  classes?:{[key: string]:any}
}) => {
  const {burrito,total} = props;
  const classes = props.classes || {};
  const burritoNum = total / burrito.cost
  const burritoTotalCalories = burritoNum * burrito.calories
  const kidsToFeed = burritoTotalCalories / 2000
    return (
      <Card className={classes.card}>
        <CardHeader
          avatar={
            <Avatar aria-label="Recipe" className={classes.avatar}>
              R
            </Avatar>
          }
          action={
            <IconButton>
              <MoreVertIcon />
            </IconButton>
          }
          title="Shrimp and Chorizo Paella"
          subheader="September 14, 2016"
        />
        <CardMedia
          className={classes.media}
          image="/static/images/cards/paella.jpg"
          title="Paella dish"
        />
        <CardContent>
          <Typography component="p">
            This impressive paella is a perfect party dish and a fun meal to cook together with your
            guests. Add 1 cup of frozen peas along with the mussels, if you like.
          </Typography>
        </CardContent>
        <CardActions className={classes.actions} disableActionSpacing>
          <IconButton aria-label="Add to favorites">
            <FavoriteIcon />
          </IconButton>
          <IconButton aria-label="Share">
            <ShareIcon />
          </IconButton>
        </CardActions>
        </Card>
    );
  }


export default withStyles(styles)(BurritoDetails);
