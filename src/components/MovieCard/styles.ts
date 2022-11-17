import { StyleSheet } from 'react-native';

import { BLACK, SCREEN_BACKGROUND } from 'constants/colors';

const styles = StyleSheet.create({
  body: {
    width: '100%',
    flexDirection: 'row',
  },
  left: {
    width: '35%',
  },
  right: {
    width: '65%',
    justifyContent: 'space-between',
  },
  image: {
    width: 106,
    height: 136,
    borderRadius: 8,
    backgroundColor: SCREEN_BACKGROUND,
  },
  title: {
    color: BLACK,
    fontWeight: '600',
    fontSize: 16,
    lineHeight: 24,
  },
  footer: {
    marginTop: 15,
  },
});

export default styles;
